package com.ag.apidesign_;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	@JsonProperty
	String id;//would be better a datastore entity, but keep it simple
	@JsonProperty
	String team;
	@JsonProperty
	String pilot;
}
