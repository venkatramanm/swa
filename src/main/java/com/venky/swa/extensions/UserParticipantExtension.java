package com.venky.swa.extensions;

import java.util.Arrays;
import java.util.List;

import com.venky.swa.db.model.User;
import com.venky.swf.db.extensions.ParticipantExtension;


public class UserParticipantExtension extends ParticipantExtension<User>{
	static {
		registerExtension(new UserParticipantExtension());
	}
	protected UserParticipantExtension() {
		super();
	}

	@Override
	protected List<Integer> getAllowedFieldValues(com.venky.swf.db.model.User user, User partial, String fieldName) {
		if ("SELF_USER_ID".equalsIgnoreCase(fieldName)) {
			return Arrays.asList(user.getId());
		}
		return null;
	}

}
