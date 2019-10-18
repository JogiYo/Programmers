package skillcheck_algo_lv2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// Programmers Level 2 : Truck passing by a bridge
// Using Queue
public class Level2_9 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input_1 = br.readLine().split(" ");
		int bridge_length = Integer.parseInt(input_1[0]);
		int weight = Integer.parseInt(input_1[1]);
		
		String[] input_2 = br.readLine().split(" ");
		int[] truck_weights = new int[input_2.length];
		
		for(int i = 0; i < input_2.length; i++) {
			truck_weights[i] = Integer.parseInt(input_2[i]);
		}
		
		sb.append(solution(bridge_length, weight, truck_weights) + "");
		System.out.print(sb);
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int total_weight = 0;
        
        // You need a queue of buses waiting 
        // and a queue of buses on the bridge.
        Queue<Truck> wait_truck = new LinkedList<>();
        Queue<Truck> ing_truck = new LinkedList<>();
        
        Truck[] trucks = new Truck[truck_weights.length];
        
        for(int i = 0; i < trucks.length; i++) {
        	trucks[i] = new Truck(bridge_length, truck_weights[i]);
        	wait_truck.offer(trucks[i]);
        }
        
        total_weight += wait_truck.peek().weight;
        ing_truck.offer(wait_truck.poll());
        
        while(!ing_truck.isEmpty()) {
        	for(Truck truck : ing_truck) {
        		truck.time--;
        	}
        	
        	if(ing_truck.peek().time < 0) {
        		total_weight -= ing_truck.poll().weight;
        	}
        	
        	if(!wait_truck.isEmpty() && total_weight + wait_truck.peek().weight <= weight) {
        		total_weight += wait_truck.peek().weight;
        		// The moment the new bus enters, the distance is deducted by one.
        		int time = bridge_length-1;
        		int wht = wait_truck.poll().weight;
        		ing_truck.offer(new Truck(time, wht));
        	}
        	answer++;
        }
        
        return answer;
    }
	
	static class Truck {
		int time;
		int weight;
		
		public Truck(int time, int weight) {
			this.time = time;
			this.weight = weight;
		}
	}
}