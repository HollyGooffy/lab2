public class Name {
    private String SecName, Fername, THName;

    Name(){
        this.SecName = null;
        this.Fername = null;
        this.THName = null;
    }

    Name(String Secname, String Fername, String THName){
        this.SecName = Secname;
        this.Fername = Fername;
        this.THName = THName;
    }

    String setSecName(String Secname) {
        this.SecName = Secname;
        return this.SecName;
    }

    public String setFername(String Fername) {
        this.Fername = Fername;
        return Fername;
    }

    public String setTHName(String THName) {
        this.THName = THName;
        return THName;
    }

    public String getSecName() {
        return SecName;
    }

    public String getFername() {
        return Fername;
    }

    public String getTHName() {
        return THName;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        if (SecName != null){
            sb.append(SecName).append(" ");
        }
        if (Fername != null){
            sb.append(Fername).append(" ");
        }
        if (THName != null){
            sb.append(THName).append(" ");
        }
        return sb.toString();
    }

}


