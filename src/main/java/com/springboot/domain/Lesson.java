package com.springboot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**Persistence class for LESSON Table.
 * @author RAJASHEKHAR
 *
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Lesson {
	
	private Long lessonId;
	private String lessonName;
	private Integer lessonNumber;
	
	// course maps lessons (1 to many.)
	//lesson to course (many to 1)
	
	
	private Section section;

	@Id
	@GeneratedValue
	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public Integer getLessonNumber() {
		return lessonNumber;
	}

	public void setLessonNumber(Integer lessonNumber) {
		this.lessonNumber = lessonNumber;
	}

	@ManyToOne
	@JoinColumn(name = "section_id")
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lessonId == null) ? 0 : lessonId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		if (lessonId == null) {
			if (other.lessonId != null)
				return false;
		} else if (!lessonId.equals(other.lessonId))
			return false;
		return true;
	}

}
