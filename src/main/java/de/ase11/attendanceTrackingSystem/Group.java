package de.ase11.attendanceTrackingSystem;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.lang.String;

@Entity
public class Group {
	@Id private Long id;

	@Index private int group_number;
	private String meeting_location;
	private String meeting_time;
	private String instructor_name;

	public Group() {
	}
	
	/**
	 * The @param id should be set by Objectify automatically.
	 * I'm not completely sure, yet if we should have it public or private is okay.
	 * @param group_number
	 * @param meeting_location
	 * @param meeting_time
	 * @param instructor_name
	 */
	public Group(int group_number, String meeting_location, String meeting_time, String instructor_name) {
		this.group_number = group_number;
		this.meeting_location = meeting_location;
		this.meeting_time = meeting_time;
		this.instructor_name = instructor_name;
	}
	
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the group_number
	 */
	public int getGroup_number() {
		return group_number;
	}
	/**
	 * @param group_number the group_number to set
	 */
	public void setGroup_number(int group_number) {
		this.group_number = group_number;
	}
	/**
	 * @return the meeting_location
	 */
	public String getMeeting_location() {
		return meeting_location;
	}
	/**
	 * @param meeting_location the meeting_location to set
	 */
	public void setMeeting_location(String meeting_location) {
		this.meeting_location = meeting_location;
	}
	/**
	 * @return the meeting_time
	 */
	public String getMeeting_time() {
		return meeting_time;
	}
	/**
	 * @param meeting_time the meeting_time to set
	 */
	public void setMeeting_time(String meeting_time) {
		this.meeting_time = meeting_time;
	}
	/**
	 * @return the instructor_name
	 */
	public String getInstructor_name() {
		return instructor_name;
	}
	/**
	 * @param instructor_name the instructor_name to set
	 */
	public void setInstructor_name(String instructor_name) {
		this.instructor_name = instructor_name;
	}
}
