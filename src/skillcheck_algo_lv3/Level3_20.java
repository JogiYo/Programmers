package skillcheck_algo_lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

// Programmers Level 3 : Best album
// using HashMap and ArrayList
public class Level3_20 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		String[] genres = br.readLine().split(", ");
		String[] input = br.readLine().split(", ");
		int[] plays = new int[input.length];
		
		for(int i = 0; i < plays.length; i++) {
			plays[i] = Integer.parseInt(input[i]);
		}
		
		int[] result = solution(genres, plays);
		for(int i = 0 ; i < result.length; i++) {
			sb.append(result[i] + " ");
		}
		System.out.print(sb);
	}
	
	public static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        ArrayList<Integer> album = new ArrayList<>();
        ArrayList<Song> songlist = new ArrayList<>();
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, Integer> albumMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
        	int id = i;
        	int play = plays[i];
        	String genre = genres[i];
        	
        	songlist.add(new Song(id, play, genre));
        	// Save play count for each genre
        	if(!genreMap.containsKey(genre)) {
        		genreMap.put(genre, play);
        	}
        	else {
        		genreMap.put(genre, genreMap.get(genre) + play);
        	}
        }
        
        Collections.sort(songlist, new Comparator<Song>() {
			@Override
			public int compare(Song s1, Song s2) {
				if(s1.genre.equals(s2.genre)) {
					return s1.compareTo(s2);
				}
				// Descending order by number of plays
				else return genreMap.get(s2.genre) - genreMap.get(s1.genre);
			}
        });
        
        // Based on the sorted list, 2 ids are added for each genre.
        for(Song song : songlist) {
        	if(!albumMap.containsKey(song.genre)) {
        		albumMap.put(song.genre, 1);
        		album.add(song.id);
        	}
        	else {
        		if(albumMap.get(song.genre) == 1) {
        			albumMap.put(song.genre, albumMap.get(song.genre) + 1);
        			album.add(song.id);
        		}
        		else continue;
        	}
        }
        
        answer = new int[album.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = album.get(i);
        }
        return answer;
    }
	
	static class Song implements Comparable<Song> {
		int id, play;
		String genre;
		
		Song(int id, int play, String genre) {
			this.id = id;
			this.play = play;
			this.genre = genre;
		}
		// When the genre is the same
		// Sort id in ascending order and play in descending order
		@Override
		public int compareTo(Song other) {
			if(this.play == other.play) {
				return this.id - other.id;
			}
			else {
				return other.play - this.play;
			}
		}
	}
}