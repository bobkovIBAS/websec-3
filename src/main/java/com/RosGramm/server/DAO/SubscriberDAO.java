package com.RosGramm.server.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubscriberDAO {

    private String firstname;
    private String lastname;
    private String email;

}
