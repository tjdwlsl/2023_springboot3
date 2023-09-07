package com.ict.edu3.service.members;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ict.edu3.mapper.memebers.Member_Mapper;
import com.ict.edu3.model.members.MemberVO;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    @NonNull
    private Member_Mapper member_Mapper;


    public List<MemberVO> getList(){
        log.info("list-service");
        List<MemberVO> list = member_Mapper.getList();
        return list;
    }

    public int getIDCnt(String id){
        int cnt = member_Mapper.getIDCnt(id);
        return cnt;
    }
    public int getMemberAdd(MemberVO vo){
        int cnt = member_Mapper.getMemberAdd(vo);
        return cnt;
    }
      public MemberVO getMemberOne(String id){
        MemberVO vo = member_Mapper.getMemberOne(id);
        return vo;
    }
}
