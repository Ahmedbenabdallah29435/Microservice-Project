package com.esprit.microservices.candidate.service;

import com.esprit.microservices.candidate.domain.Plan;

import java.util.List;

public interface IPlan {
    Plan create(Plan p, int userId) throws Exception;

    Plan get(Integer planid);

    List<Plan> PLAN_DTOS();

    Boolean update(Plan c);

    boolean delete(int id);

    double getChiffreAffaireByOffer(int offerId);

    Plan savePlan(Plan plan, /*@NonNull HttpServletRequest request*/ int id) throws Exception;

    int addplan1(Plan plan, int idUser);
}
