package com.ead.course.repositories;

import com.ead.course.models.CourseModel;
import com.ead.course.models.ModuleModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ModuleRepository extends JpaRepository<ModuleModel, UUID>, JpaSpecificationExecutor<ModuleModel> {

    /* Dessa maneira eu consigo acessar o modulo que estou procurando e recebendo os dados tambem de qual curso
    ele está inserido, mesmo utilizando  o FetchType Lazy, ele faz com que este metodo em especifico me retorne um
     FetchType Eager do Course

    @EntityGraph(attributePaths = "course")
    ModuleModel findByTitle(String title);
     */
    @Query(value = "select * from tb_modules where course_course_id = :courseId", nativeQuery = true)
    List<ModuleModel> findAllModulesIntoCourse(@Param("courseId") UUID courseId);


    @Query(value = "select * from tb_modules where module_id = :moduleId and course_course_id = :courseId", nativeQuery = true)
    Optional<ModuleModel> findModuleIntoCourse(@Param("moduleId") UUID moduleId, @Param("courseId") UUID courseId);
}
