package app.componentes;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import javax.swing.text.DocumentFilter.FilterBypass;

public class ViewPeso extends JTextField{

	public ViewPeso() {
		super();
		this.setText("0");
		
		((AbstractDocument)this.getDocument()).setDocumentFilter(new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
				if(string == null || string.isEmpty() || !esEntero(string) ||  Integer.parseInt(string) < 0) {
					super.insertString(fb, offset, "0", attr);
				}else {
					super.insertString(fb, offset, string, attr);
				}
			}
			
			@Override
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
				if(text == null || text.isEmpty() || !esEntero(text) ||  Integer.parseInt(text) < 0) {
					super.replace(fb, offset, length, "0", attrs);
				}else {
					super.replace(fb, offset, length, text, attrs);
				}
			}
		});
	}
	
	@Override
	public void setText(String text) {
		
		if(text == null || text.isEmpty() || !esEntero(text) ||  Integer.parseInt(text) > 0) {
			super.setText("0");
		}else{
			super.setText(text);
		}
	}
	
	

	private boolean esEntero(String texto) {
	    try {
	        Integer.parseInt(texto);
	        return true; // El texto es un entero
	    } catch (NumberFormatException e) {
	        return false; // El texto no es un entero
	    }
	}
}
