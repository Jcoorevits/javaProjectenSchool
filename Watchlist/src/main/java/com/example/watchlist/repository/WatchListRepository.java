package com.example.watchlist.repository;

import com.example.watchlist.model.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchListRepository extends JpaRepository<Watchlist, Long> {
}
