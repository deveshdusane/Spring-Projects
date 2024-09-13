package com.example.demo.response;

import java.util.List;

import com.example.demo.pojo.PlayerPOJO;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerResponse {

	private String msg;
	private PlayerPOJO data;
	private List<PlayerPOJO> list;
}
