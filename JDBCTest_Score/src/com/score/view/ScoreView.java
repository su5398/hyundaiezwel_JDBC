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
				
				System.out.println(s);
				
			case 4:
			case 5:
			case 6:
				//종료
				System.out.println("종료되었습니다.");
				break;
			}
			
		}
	}

}
