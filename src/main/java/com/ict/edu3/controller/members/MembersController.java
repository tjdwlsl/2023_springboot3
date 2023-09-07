package com.ict.edu3.controller.members;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ict.edu3.model.members.DataVO;
import com.ict.edu3.model.members.MemberVO;
import com.ict.edu3.service.members.MemberService;

@RestController
@RequestMapping("/member")
public class MembersController {
    @Autowired
    private MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/")
    public String Hello(){
        return "Hello World";
    }

    @PostMapping("/login")
    public  Map<String, Object> logIn(MemberVO vo){
        Map<String, Object> resMap = new HashMap<>();
        DataVO dataVO = new DataVO();
        // 해당 아이디로 
        // 입력한 id의 패스워드를 DB에 가져와서 입력한 pwd와 비교해서 맞으면 성공 틀리면 실패
        // id로 DB에 저장된 pwd 가져오기 
        int cnt = memberService.getIDCnt(vo.getM_id());
       if(cnt <= 0){
            dataVO.setSuccess(false);
            dataVO.setMessage("아이디가 존재하지 않습니다.");
            resMap.put("data", dataVO);
            return resMap;

       }else{
            MemberVO mvo = memberService.getMemberOne(vo.getM_id());
           if(! passwordEncoder.matches(vo.getM_pw(), mvo.getM_pw())) {
        //   if(! vo.getM_pw().equals( mvo.getM_pw())) {
                dataVO.setSuccess(false);
                dataVO.setMessage("비밀번호가 틀립니다.");
                resMap.put("data", dataVO);
                return resMap;
           }else {
                dataVO.setSuccess(true);
                dataVO.setMessage("로그인 성공");
                dataVO.setData(mvo);
                resMap.put("data", dataVO);
                return resMap;
           }
       }

    }

    @PostMapping("/join")
    public  Map<String, Object> join(MemberVO vo){
        Map<String, Object> resMap = new HashMap<>();
        DataVO dataVO = new DataVO();
        vo.setM_pw(passwordEncoder.encode(vo.getM_pw()));
        int result = memberService.getMemberAdd(vo);
        if(result>0){
            dataVO.setSuccess(true);
            dataVO.setMessage("회원가입 성공");
            resMap.put("data", dataVO);
        }else{
            dataVO.setSuccess(false);
            dataVO.setMessage("회원가입 실패");
            resMap.put("data", dataVO);
        }
        return resMap;
    }
    @GetMapping("/list")
    public Map<String, Object> getList(){
        List<MemberVO> list = memberService.getList();
        Map<String, Object> resMap = new HashMap<>();
        resMap.put("list", list);
        return resMap ;
    }

}