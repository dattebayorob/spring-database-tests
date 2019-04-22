package com.dtb.springdatabase.model.repositories.dbone.custom;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.dtb.springdatabase.model.entities.People;
import com.dtb.springdatabase.model.entities.Worplace;

public class PeopleRepositoryImpl implements PeopleRepositoryQuery {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<People> findByFilters(Map<String, String> filters) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<People> cq = builder.createQuery(People.class);
		Root<People> root = cq.from(People.class);
		root.fetch("address", JoinType.INNER);
		root.fetch("workplace", JoinType.INNER).fetch("address", JoinType.INNER)
		.fetch("city", JoinType.INNER).fetch("federationUnity", JoinType.INNER);
		From<People, Worplace> workPlaceJoin = root.join("workplace", JoinType.INNER).join("address", JoinType.INNER)
				.join("city", JoinType.INNER).join("federationUnity", JoinType.INNER);
		cq.where(predicates(filters, builder, root, workPlaceJoin));
		return em.createQuery(cq)
				.getResultList();

	}

	private Predicate[] predicates(Map<String, String> filters, CriteriaBuilder criteriaBuilder, Root<People> root,
			From<?, ?> from) {
		List<Predicate> p = new LinkedList<>();
		if (filters.get("name") != null && !StringUtils.isEmpty(filters.get("name"))) {
			p.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
					"%" + filters.get("name").toLowerCase() + "%"));
		}
		if (filters.get("fu") != null && !StringUtils.isEmpty(filters.get("fu"))) {
			p.add(criteriaBuilder.equal(from.get("initials"), filters.get("fu")));
		}
		return p.toArray(new Predicate[p.size()]);
	}

}
