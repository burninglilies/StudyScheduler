import java.io.IOException;
import java.io.RandomAccessFile;


public class Task extends Project {
    private boolean dueToday;
    private boolean dueTomorrow;
    private boolean overdue;
    private int duration_mins;
    
       
   public Task(String name, String description, int duration_mins, boolean dueToday, boolean dueTomorrow, boolean overdue) {
       super(name, description);
       this.duration_mins = duration_mins;
       this.dueToday = dueToday;
       this.dueTomorrow = dueTomorrow;
       this.overdue = overdue;
       
   }
   Task() {
       
   }
   
   public boolean getDueToday() {
       return this.dueToday;
   }
   
   public boolean getDueTomorrow() {
       return this.dueTomorrow;
   }
   
   public boolean getOverdue() {
       return this.overdue;
   }
   
   public int getDuration_mins() {
       return duration_mins;
   }
   
   public String convertHoursMessage() {
        return "Hours needed to complete task: " + getDuration_mins()/60.0 ;
   }
   
   public String toText() {
       return "This task is going to take " + duration_mins + " mins";
   }
   
   
   public void read(RandomAccessFile raf) throws IOException {
        char[] temp = new char[15];
        for(int i = 0; i< temp.length; i++)
            temp[i] = raf.readChar();
        super.setName(new String(temp));
        
        temp = new char[30];
        for(int i = 0; i<temp.length; i++)
            temp[i] = raf.readChar();
        
        dueToday = raf.readBoolean();
        dueTomorrow = raf.readBoolean();
        overdue = raf.readBoolean();
        duration_mins = raf.readInt();
    }
    
    public void write(RandomAccessFile raf, int i) throws IOException {
        StringBuffer sb;
        
        //write name
        if (super.getName() != null) {
            sb = new StringBuffer(super.getName());
        } else {
            sb = new StringBuffer();
        }
        sb.setLength(15*i);
        raf.writeChars(sb.toString());
        //write description
        if(super.getDescription() != null) {
            sb = new StringBuffer(super.getDescription());
        } else {
            sb = new StringBuffer();
        }
        sb.setLength(25*i);
        raf.writeChars(sb.toString());
        //write dueToday, dueTomorrow, overdue booleans
        raf.writeBoolean(dueToday);
        raf.writeBoolean(dueTomorrow);
        raf.writeBoolean(overdue);
        //write duration minutes
        raf.writeInt(duration_mins);
    }
}