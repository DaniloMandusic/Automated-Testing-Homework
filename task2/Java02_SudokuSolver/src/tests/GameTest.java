package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import nl.elridge.sudoku.model.Game;

class GameTest {

	@Test
	void testHelp() {
		Game game = new Game();
		
		game.setHelp(true);
		
		assertEquals(true,game.isHelp());
		
	}
	
	@Test
	void testMock() {
		//Game g = mock(Game.class);
		
		
		
		
	}

}