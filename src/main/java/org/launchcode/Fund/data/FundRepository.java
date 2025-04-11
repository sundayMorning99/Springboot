package org.launchcode.Fund.data;

import org.launchcode.Fund.models.Fund;
import org.springframework.stereotype.Repository;

//under data, create new Java class - Interface / name it EventRepository
//Create Event object and save primary key as integer
//class will be stored in the database.
@Repository
public interface FundRepository extends CrudRepository<Fund, Integer>{}