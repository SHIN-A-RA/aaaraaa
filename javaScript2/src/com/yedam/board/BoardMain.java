package com.yedam.board;

import java.util.List;

public class BoardMain {
		public static void main(String[]args) {
			BoardDAO b = new BoardDAO();
			List<Board> blist = b.getBoardList();
			for(Board bor : blist) {
				System.out.println(bor);
		
			}
			Board board = new Board();
			board.setWriter("user1");
			board.setContent("java test");
			b.insertBoard(board);
			
			board=b.getBoardInfo(1);
			System.out.println(board);
		}


}
