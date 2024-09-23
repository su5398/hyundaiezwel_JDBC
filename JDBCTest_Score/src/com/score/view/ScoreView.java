package com.score.view;

import java.util.List;
import java.util.Scanner;

import com.score.model.biz.ScoreServiceImpl;
import com.score.model.dto.Score;

//view + controller
public class ScoreView {
	static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		System.out.print("********************\n");
		System.out.println("1. 전체출력");
		System.out.println("2. 선택출력");
		System.out.println("3. 추가");
		System.out.println("4. 수정");
		System.out.println("5. 삭제");
		System.out.println("6. 종료");
		
		System.out.print("메뉴 선택: ");
		int select = sc.nextInt();
		return select;
	}
	
	public static void main(String[] args) {
		ScoreServiceImpl biz = new ScoreServiceImpl();
		
		int select = 0;
		
		String name=null;
		int kor=0;
		int eng=0;
		int math=0;
		
		int res=0;
		
		while(select != 6) {
			select = getMenu();
			
			switch(select) {
			case 1:
				//전체출력
				List<Score> all = biz.getAll();
				for(Score s : all) {
					System.out.println(s);
				}
				break;
			case 2:
				//선택출력
				System.out.print("선택할 이름: ");
				name = sc.next();
				Score one = biz.getOne(name);
				System.out.println(one);
				break;
			case 3:
				//추가
				System.out.print("추가할 이름: ");
				name=sc.next();
				System.out.print("국어 점수: ");
				kor=sc.nextInt();
				System.out.print("영어 점수: ");
				eng=sc.nextInt();
				System.out.print("수학 점수: ");
				math=sc.nextInt();
				
				Score s = new Score(name,kor,eng,math);
				s.scoreSum();
				s.scoreAvg();
				s.scoreGrade();
				
				res = biz.insert(s);
				if(res>0) {
					System.out.println("추가 성공");
				}else {
					System.out.println("추가 실패");
				}
				break;
			case 4:
				//수정
				System.out.print("수정할 이름: ");
				name=sc.next();
				
				Score check = biz.getOne(name);
				if(check != null) {
					System.out.print("이전 국어 점수: "+check.getKor()+" - 바꿀 국어 점수: ");
					kor = sc.nextInt();
					System.out.print("이전 영어 점수: "+check.getEng()+" - 바꿀 영어 점수: ");
					eng = sc.nextInt();
					System.out.print("이전 수학 점수: "+check.getMath()+" - 바꿀 수학 점수: ");
					math = sc.nextInt();
					
					Score up = new Score(name, kor, eng, math);
					up.scoreSum();
					up.scoreAvg();
					up.scoreGrade();
					
					res = biz.update(up);
					
					if(res>0) {
						System.out.println(name+" 수정 성공");
					}else {
						System.out.println("수정 실패");
					}
					break;
					
					
				}else {
					System.out.println("해당 이름이 없습니다.");
				}
				break;
			case 5:
				//삭제
				System.out.println("삭제할 이름: ");
				name = sc.next();
				
				res = biz.delete(name);
				if(res>0) {
					System.out.print(name+ " 삭제 성공");
				}else {
					System.out.print("삭제 실패");
				}
				break;
			case 6:
				//종료
				System.out.println("종료되었습니다.");
				break;
			}
			
		}
	}

}
