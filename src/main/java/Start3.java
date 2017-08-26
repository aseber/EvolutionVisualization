/*package main.java;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
import java.nio.ByteBuffer;
//import org.lwjgl.glfw.GLFWvidmode;

public class Start3 implements Runnable{

    private Thread thread;
    public boolean running = true;

    private long window;

    private int width = 1200, height = 800;

    public static void main(String args[]){
        Start3 game = new Start3();
        game.start();
    }

    public void start(){
        running = true;
        thread = new Thread(this, "EndlessRunner");
        thread.start();
    }

    public void init(){
        // Initializes our window creator library - GLFW
        // This basically means, if this glfwInit() doesn't run properlly
        // print an error to the console
        if(glfwInit() != GL_TRUE){
            // Throw an error.
            System.err.println("GLFW initialization failed!");
        }

        // Allows our window to be resizable
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

        // Creates our window. You'll need to declare private long window at the
        // top of the class though.
        // We pass the width and height of the game we want as well as the title for
        // the window. The last 2 NULL parameters are for more advanced uses and you
        // shouldn't worry about them right now.
        window = glfwCreateWindow(width, height, "Endless Runner", NULL, NULL);

        // This code performs the appropriate checks to ensure that the
        // window was successfully created.
        // If not then it prints an error to the console
        if(window == NULL){
            // Throw an Error
            System.err.println("Could not create our Window!");
        }

        // creates a bytebuffer object 'vidmode' which then queries
        // to see what the primary monitor is.
        ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        // Sets the initial position of our game window.
        glfwSetWindowPos(window, 100, 100);
        // Sets the context of GLFW, this is vital for our program to work.
        glfwMakeContextCurrent(window);
        // finally shows our created window in all it's glory.
        glfwShowWindow(window);
    }

    public void update(){
        // Polls for any window events such as the window closing etc.
        glfwPollEvents();
    }

    public void render(){
        // Swaps out our buffers
        glfwSwapBuffers(window);
    }

    @Override
    public void run() {
        // All our initialization code
        init();
        // Our main game loop
        while(running){
            update();
            render();
            // Checks to see if either the escape button or the
            // red cross at the top were pressed.
            // if so sets our boolean to false and closes the
            // thread.
            if(glfwWindowShouldClose(window) == GL_TRUE){
                running = false;
            }
        }
    }
}*/