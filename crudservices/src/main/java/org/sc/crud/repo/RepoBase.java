package org.sc.crud.repo;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface RepoBase <T, ID extends Serializable> extends JpaRepository<T, ID>{
    public static Integer MAX_PAGE_SIZE = 10;
}

