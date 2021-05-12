package emailapp;

import java.util.Scanner;

public class Email {
	// 필요한 변수들 선언 (성,이름,비밀번호,부서,이메일주소 ,메일용량, 대체이메일)
	// private : 선언된 클래스 내에서만 접근 가능
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailBoxCapacity = 500;	
	private int defaultPasswordLength = 10; //비밀번호 길이
	private String alternateEmail;
	private String companySuffix = "jycompany.com"; // 회사기본주소
	
	// 이름과 성을 받을 생성자, 변수 초기화
	public Email(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("이메일이 생성됨 : "+this.firstName+" "+this.lastName);
		
		// 부서를 묻는 메서드 호출 - (부서명을 반환함)
		this.department  = setDepartment();
		//System.out.println("부서: "+this.department);
		
		// 10자리의 비밀번호를 반환하는 메서드 호출
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("당신의 비밀번호는 : "+ this.password);
		
		// 이메일 생성을 위해 요소 결합
		email = firstName.toLowerCase() +"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
		//System.out.println("당신의 이메일은 : "+email);
	}
	
	// 부서를 묻는 메서드
	private String setDepartment() {
		System.out.print("신입사원 : " + firstName+" "+lastName+ "님의" + " 부서 코드 입력\n1.영업\n2.개발\n3.회계\n4.마케팅\n0.부서미정 \n소속부서의 코드입력:");
		Scanner s = new Scanner(System.in);
		
		int depChoice = s.nextInt();
		if(depChoice == 1) {
			return "sales";
		}else if(depChoice == 2) {
			return "dev";
		}else if(depChoice == 3) {
			return "acct";
		}else if(depChoice == 4){
			return "mak";
		}else {
			return " ";
		}
	}
	
	// 랜덤한 비밀번호 생성
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%";
		char[] password= new char[length];
		for(int i=0;i<length;i++) {
			int rand = (int) (Math.random() * passwordSet.length()); //passwordSet의 길이만큼 숫자
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	// 메일함의 용량설정
	public void setMailboxCapacity(int capacity) {
		this.mailBoxCapacity = capacity;
	}
	
	// 대체이메일 생성
	public void setAlternateEamil(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// 비밀번호 변경
	public void changePassword(String password) {
		this.password = password;
	}
	
	//get
	public int getMailboxCapacity() {
		return mailBoxCapacity;
	}
	
	public String getAlternateEamil() {
		return alternateEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String showInfo() {
		return "이름 : "+ firstName + " "+ lastName + 
			   "\n회사이메일 : "+ email +
			   "\n메일함 용량 : "+mailBoxCapacity + "mb";
	}
}
