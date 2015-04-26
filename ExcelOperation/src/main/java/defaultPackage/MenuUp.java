package defaultPackage;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

class MenuUp extends MenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuUp() {
		 Menu m1 = new Menu( "File" );
		 Menu m2 = new Menu( "Help" ); //���������˵�Ŀ¼��
		 MenuItem mi1 = new MenuItem( "Clear" );
		 MenuItem mi2 = new MenuItem( "Print" );
		 MenuItem mi3 = new MenuItem( "Quit" ); //����3���˵���
		 m1.add( mi1 );
		 m1.add( mi2 );
		 m1.addSeparator();
		 m1.add( mi3 ); //��3���˵�����ӵ���ΪFile�Ĳ˵��£����ӷָ���
		 add( m1 );
		 add( m2 );
		 setHelpMenu( m2 ); //���˵�Ŀ¼����ӵ�MenuBar��
	}
}