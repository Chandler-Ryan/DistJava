package com.genre.withjpa;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<movieGenre, String> {
}
