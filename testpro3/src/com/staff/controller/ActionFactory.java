package com.staff.controller;

import com.staff.Action.AllmamberAddAction;

import com.staff.Action.Pj_History_InsertAction;
import com.staff.Action.Pj_History_InsertFormAction;
import com.staff.Action.Pj_History_ListAction;
import com.staff.Action.Pj_History_UpdateAction;
import com.staff.Action.Pj_History_UpdateFormAction;
import com.staff.Action.Staff_History_ListViewAction;
import com.staff.Action.Staff_History_UpdateFormAction;
import com.staff.Action.Staff_History_ViewAction;
import com.staff.Action.staff_History_Update;
import com.staff.Action.LoginAction;
import com.staff.Action.LoginFormAction;
import com.staff.Action.MainAction;
import com.staff.Action.NoticeAction;
import com.staff.Action.NoticeDelete;
import com.staff.Action.NoticeDetailAction;
import com.staff.Action.NoticeInsertAction;
import com.staff.Action.NoticeInsertFromAction;
import com.staff.Action.NoticeUpdate;
import com.staff.Action.NoticeUpdateForm;
import com.staff.Action.Pj_History_DetailAction;
import com.staff.common.Action;
import com.staff.controller.ActionFactory;

public class ActionFactory {
private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action =null;
		//처음 로그인창 가는 엔덱스 
		if (command.equals("loginForm")) {
			action = new LoginFormAction();
			//처음 회원가입하는 서블릿
		}else if (command.equals("AllmemberAdd")) {
			action = new AllmamberAddAction();
			//로그인 서블릿
		}else if (command.equals("loginAction")) {
			action = new LoginAction();
			//사이드 매뉴 관리 
			//매인
		}else if (command.equals("main")) {
			action = new MainAction();	
			//프로젝트 이력 목록
		}else if (command.equals("pj_History_List")) {
			action = new Pj_History_ListAction();
			//프로젝트 이력 등록
		}else if (command.equals("pj_History_InsertForm")) {
			action = new Pj_History_InsertFormAction();
			//사원 정보 목록
		}else if (command.equals("staff_History_ListView")) {
			action = new Staff_History_ListViewAction();
			//사원 정보 수정 
		}else if (command.equals("staff_History_UpdateForm")) {
			action = new Staff_History_UpdateFormAction();
			//사원 정보 뷰 //수정버튼 클릭시 수정으로 갑니다.
		}else if (command.equals("staff_History_View")) {
			action = new Staff_History_ViewAction();
			//공지 사항 // 사이드 매뉴 관리 끝
		}else if (command.equals("notice")) {
			action = new NoticeAction();
			//스테프 업뎃
		}else if (command.equals("staff_History_Update")){
			action = new staff_History_Update();
			//프로젝트 디테일
		}else if (command.equals("Pj_History_Detail")){
			action = new Pj_History_DetailAction();
			//notice디테일
		}else if (command.equals("noticeDetail")) {
			action = new NoticeDetailAction();
			//노티스 등록폼으로 가기
		}else if (command.equals("noticeInsertForm")) {
			action = new NoticeInsertFromAction();
			//노티스 인설트
		}else if (command.equals("noticeInsert")) {
			action = new NoticeInsertAction();
			//노티스 업댓폼
		}else if (command.equals("noticeUpdateForm")){
			action = new NoticeUpdateForm();
			//노티스 업뎃
		}else if (command.equals("noticeUpdate")){
			action = new NoticeUpdate();
			//노티스 삭제
		}else if (command.equals("noticeDelete")){
			action = new NoticeDelete();
			//프로젝트 insert 
		}else if (command.equals("pj_History_Insert")){
			action = new Pj_History_InsertAction();
			//프로젝트 업뎃 폼
		}else if (command.equals("pj_History_UpdateForm")){
			action = new Pj_History_UpdateFormAction();
			//프로젝트 업뎃
		}else if (command.equals("pj_History_Update")){
			action = new Pj_History_UpdateAction();
		}
		return action;
	}
}
