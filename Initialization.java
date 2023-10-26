import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.ArrayList;

public class Initialization {
    private final JSONObject gameSettings;
    private final JSONObject terrainSettings;
    public Initialization(String terrainPath, String gamePath){
        Read readInput = new Read();
        this.terrainSettings = (JSONObject) readInput.readFile(terrainPath);
        this.gameSettings = (JSONObject) readInput.readFile(gamePath);
    }

    public int getTerrainLength(){
        return (int) terrainSettings.get("length");
    }

    public int getTerrainHeight(){
        return (int) terrainSettings.get("height");
    }

    public ArrayList<Team> setTeams(){
        JSONObject teamsFromFile = (JSONObject) gameSettings.get("Teams");
        ArrayList<Team> teams = new ArrayList<Team>();
        long numOfTeams = (long) gameSettings.get("Number of Teams");
        for(int i = 1; i < numOfTeams; i++){
            JSONObject actualTeam = (JSONObject) teamsFromFile.get("Time" + i);
            Team team = new Team((int) actualTeam.get("number of robots"), (String) actualTeam.get("name"), (String) actualTeam.get("controller type"));
            teams.add(team);
        }
        return teams;
    }
}
