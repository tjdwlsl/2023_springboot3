package com.ict.edu3.model.members;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String m_idx, m_id, m_pw, m_name, m_age, m_reg;
    
}
