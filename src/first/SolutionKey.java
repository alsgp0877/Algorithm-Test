package first;

//input:string output:string 
public class SolutionKey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String key = "8F3Z-2e-9-w";
		solve(key,4);

	}
	
	public static String solve(String s, int k) {
		
		//-�� ���ִ°� �´°ɱ�? -�� �������� ���ڿ��� �����°� ���?
		//-�� ���ַ��� �Ѵٸ� ���ְ� ���� ���ڿ��� ���ؼ� �׺κ��� ���Ե� �κл��� �������� k�� ���� ������?
		//�ֳĸ� ù��°���� ������ �����ϰ� ���������ϱ� 'ù��°����-'�̰� �ڿ����� �߶󳻸� �ɰ� ������?
		
		//���ڿ��� �������� ù�뽬�� �������� �յڸ� ������. 
		String[] str = s.split("-");
		System.out.println(str[0]);//ù����
		System.out.println(str[1]);//��
		System.out.println(str[2]);//��
		System.out.println(str[3]);//�� 
		StringBuilder second = new StringBuilder();
		String first="";
		
		for(int i=0;i<str.length;i++) {
			
			if(i==0) {
				first = str[0];
			}else {
				second.append(str[i]);
		
			}
		}
		
		//�޺κп��� ���� k�� ���� ���� ������ �������ϴµ� 
		//���࿡ k�� 2�� �������� 2-2 �̶������� �������. 
		
		System.out.println(first.toUpperCase() + '-' + second.toString().toUpperCase());//�� 

		for(int i=0;i<second.length();i++) {
			//https://okky.kr/article/230197
			
			
		}
		
		
		return null;
		
	}

}
