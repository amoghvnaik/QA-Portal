package com.qa.portal.cv.domain;

import java.util.List;

public class Profile {

	private String profileDetails;

	private List<Feedback> profileFeedback;
	
	public Profile() {
		super();
	}

	public String getProfileDetails() {
		return profileDetails;
	}

	public void setProfileDetails(String profileDetails) {
		this.profileDetails = profileDetails;
	}

	public List<Feedback> getProfileFeedback() {
		return profileFeedback;
	}

	public void setProfileFeedback(List<Feedback> profileFeedback) {
		this.profileFeedback = profileFeedback;
	}

	@Override
	public String toString() {
		return "Profile [profileDetails=" + profileDetails + ", profileFeedback={" + feedbackListToString() + "}]";
	}

	private String feedbackListToString() {
		String result = "";

		if (this.getProfileFeedback().size() > 0) {
			StringBuilder sb = new StringBuilder();

			for (Feedback feedback : this.getProfileFeedback()) {
				sb.append(feedback.toString()).append(",");
			}

			result = sb.deleteCharAt(sb.length() - 1).toString();
		}
		return result;
	}
}
