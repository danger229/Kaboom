import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class KABOOM
{

    public static void main(String[] args)
    {
        
        try
        {
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex)
        {}
        
        // GlobalScreen.addNativeKeyListener(new KaboomPlay());              
        GlobalScreen.addNativeMouseListener(new GlobalMouseListenerExample());
        GlobalScreen.addNativeMouseWheelListener(new GlobalMouseWheelListenerExample());
        
        boolean i = true;
        while(1==1)
        { i = i; }
    }
 
    
    
public static class GlobalMouseListenerExample implements NativeMouseInputListener 
{
    @Override
    public void nativeMouseClicked(NativeMouseEvent e)
    {
        if(e.getButton() == NativeMouseEvent.BUTTON1)
        {
            try
            {
                BasicPlayer player = new BasicPlayer();
                player.open(new URL("file:///" + "C:\\Program Files\\Magic\\Kaboom.mp3"));
                player.play();
            }
            catch (BasicPlayerException | MalformedURLException er) 
            {}
        }
        if(e.getButton() == NativeMouseEvent.BUTTON2)
        {
            try {
            BasicPlayer player = new BasicPlayer();
            player.open(new URL("file:///" + "C:\\Program Files\\Magic\\Sploosh.mp3"));
            player.play();
            } 
            catch (BasicPlayerException | MalformedURLException er) 
            {}
        }
    }

        @Override
        public void nativeMousePressed(NativeMouseEvent nme) {}

        @Override
        public void nativeMouseReleased(NativeMouseEvent nme) {}

        @Override
        public void nativeMouseMoved(NativeMouseEvent nme) {}

        @Override
        public void nativeMouseDragged(NativeMouseEvent nme) {}
    }

public static class GlobalMouseWheelListenerExample implements NativeMouseWheelListener {
        @Override
	public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
            
            BasicPlayer player = new BasicPlayer();
            try 
            {
                player.open(new URL("file:///" + "C:\\Program Files\\Magic\\WW_Link_BigSpin.wav"));
                player.play();
                System.out.println("ree");
            }
            catch (BasicPlayerException | MalformedURLException er) {}
	}

    }
}
