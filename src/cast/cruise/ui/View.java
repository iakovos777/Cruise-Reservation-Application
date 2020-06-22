package cast.cruise.ui;


/**
* ������ ������� ��� ���� ��� (view).
* @author ����� �����������
*
*/
public interface View {
   /**
    * ������� ��� ���. 
    */
   void open();
   
   /**
    * ������� ��� ���. 
    */
   void close();
   
   /**
    * ��������� ������ ���������.
    * @param message �� ������ ��� �����������
    */
   void showError(String message);
   
   /**
    * ��������� ������������ ������.
    * @param message �� ������ ��� �����������
    */
   void showInfo(String message);
}