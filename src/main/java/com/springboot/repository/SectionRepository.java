package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.domain.Section;

/** Repository interface SECTION table.
 * @author RAJASHEKHAR
 *
 */
@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

}
