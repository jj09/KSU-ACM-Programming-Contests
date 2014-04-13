import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Colorville {
	
	public static class Game {
		int playersCount;
		int squaresCount;
		int cardsCount;
		String[] cards;
		String board;
	}
	
	public static void main(String[] args) throws IOException {
		// read input
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		LinkedList<Game> games = new LinkedList<Game>();
		
		
		
		
		while(true) {
			String input = stdin.readLine();
			String[] sizes = input.split(" ");			
			
			int playersCount = Integer.parseInt(sizes[0]);
			if(playersCount==0)
				break;
			int squaresCount = Integer.parseInt(sizes[1]);
			int cardsCount = Integer.parseInt(sizes[2]);
			
			String board = stdin.readLine();
			
			String[] cards = new String[cardsCount];
			for(int i=0; i<cardsCount; ++i) {
				cards[i] = stdin.readLine();
			}
			
			Game game = new Game();
			game.playersCount = playersCount;
			game.squaresCount = squaresCount;
			game.cardsCount = cardsCount;
			game.board = board;
			game.cards = cards;
			games.add(game);			
		}
		
		//compute games
		for(int i=0; i<games.size(); ++i) {	
			Game game = games.get(i);
			int[] players = new int[game.playersCount];
			for(int j=0; j<players.length; ++j) {
				players[j] = -1;
			}
			
			boolean win = false;
			int currentPlayer = 0;
			int currentCard = 0;
			while(currentCard<game.cardsCount) {
				boolean foundNext = false;
				for(int j=0; j<game.cards[currentCard].length(); ++j) {
					foundNext = false;
					for(int k=players[currentPlayer]+1; k<game.squaresCount; ++k) {
						if(game.board.charAt(k)==game.cards[currentCard].charAt(j)) {
							players[currentPlayer] = k;
							foundNext = true;
							break;
						}
					}	
				}
				++currentCard;				
				if(!foundNext || players[currentPlayer]==game.squaresCount-1) {
					win = true;
					break;
				}
				currentPlayer = (currentPlayer+1) % game.playersCount;
			}
			if(win) {
				System.out.println("Player "+(currentPlayer+1)+" won after "+currentCard+" cards.");
			}
			else {
				System.out.println("No player won after "+currentCard+" cards.");
			}
		}
		
		
	}
}
