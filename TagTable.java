package project;

/*
*o kodikas einai etimos
*
*opou briksei to tag <th> bazei asterakia ston pinaka
*
*
*/

import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
import javax.swing.*;

public class TagTable {

	public static void main(String[] argv) throws Exception {

		String tag = "<table> " + "<caption>This is the caption</caption>" + "<tr> " + "<td>gr1-kel1</td>" + " <td>gr1-kel2</td>" + " <td>gr1-kel3</td>" + "</tr>"
				+ "<tr>" + "<td>gr2-kel1</td>" + "<td>gr2-kel2</td>" + "</tr></table>";

		String caption = "<caption>";
		String endCaption = "</caption>";
		String tr = "<tr>";
		String trEnd = "</tr>";

		int thesiNow = 0;
		int thesiTelous;
		int muchTr;
		int muchRow;

		String tagNow;
		String trTag;
		String epikefalida = null;

		// An iparxei caption ftiaxnei ton titlo tou pinaka
		if (tag.contains(caption)) {
			int capBegin = tag.indexOf(caption) + caption.length();
			int capend = tag.indexOf(endCaption);

			epikefalida = tag.substring(capBegin, capend);

			thesiNow = capend + endCaption.length();

			// to tagNow periexei olo to tag apo to telous tou caption
			tagNow = tag.substring(thesiNow, tag.length());
		} else {
			thesiNow = tag.indexOf(tr);
			tagNow = tag.substring(thesiNow, tag.length());
		}

		// poses grammes exei o pinakas
		muchTr = getMuchTr(tagNow);

		// exei ta stoixeia tou pinaka
		String[][] pinakas = new String[muchTr][];
		// se pies thesei exei epikefalides
		int[][] pinArTag = new int[muchTr][];

		int howRow = 0;

		int indexTh;
		int indexTd;

		int indexEndTh;
		int indexEndTd;

		thesiTelous = tagNow.indexOf(trEnd);

		// pernei to tag pou anaferete stin proti seira
		trTag = tagNow.substring(0, thesiTelous);

		// periexei olo to apo to telous tis proigoumeneis seiras
		tagNow = tagNow.substring(thesiTelous + 5);

		while (trTag.contains(tr)) {

			int countRow = 0;

			indexTh = 0;
			indexTd = 0;

			String st = null;

			// posa kelia exei i grammi
			muchRow = getTrTag(trTag);

			pinakas[howRow] = new String[muchRow];
			pinArTag[howRow] = new int[muchRow];

			while (indexTh != -1 || indexTd != -1) {

				indexTh = trTag.indexOf("<th>");
				indexTd = trTag.indexOf("<td>");

				if (indexTh == -1) {
					indexTh = trTag.length() + 1;
				} else if (indexTd == -1) {
					indexTd = trTag.length() + 1;
				}

				if (indexTh < indexTd && indexTh != -1) {
					indexEndTh = trTag.indexOf("</th>");

					st = trTag.substring(indexTh + 4, indexEndTh);
					trTag = trTag.substring(indexEndTh + 1);
					pinArTag[howRow][countRow] = 1;
				} else if (indexTd < indexTh && indexTd != -1) {
					// I thesi pou telionei to tag
					indexEndTd = trTag.indexOf("</td>");

					// ftiaxnei to onoma pou iparxei mesa sto tag
					st = trTag.substring(indexTd + 4, indexEndTd);
					trTag = trTag.substring(indexEndTd + 1);
					pinArTag[howRow][countRow] = 0;
				}
				pinakas[howRow][countRow] = st;

				indexTh = trTag.indexOf("<th>");
				indexTd = trTag.indexOf("<td>");
				countRow++;
			}
			howRow++;

			thesiTelous = tagNow.indexOf(trEnd);
			trTag = tagNow.substring(0, thesiTelous);

			indexTh = tagNow.indexOf("<th>");
			indexTd = tagNow.indexOf("<td>");

			tagNow = tagNow.substring(thesiTelous);

		}

		int column = 0;

		// posa kelia exei i megaliteri grammi
		for (int i = 0; i < pinakas.length; i++) {
			if (pinakas[i].length > column) {
				column = pinakas[i].length;
			}
		}

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		if (epikefalida != null) {
			panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), epikefalida,
					TitledBorder.CENTER, TitledBorder.TOP));
		}

		JTable table = new JTable(howRow, column);
		table.setTableHeader(null);
		panel.add(table);

		// table.setSize(500, 100);

		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);

		// JScrollPane scrollPane = new JScrollPane(table);
		// frame.add(scrollPane, BorderLayout.CENTER);
		frame.setSize(300, 150);

		for (int i = 0; i < howRow; i++) {
			for (int y = 0; y < pinakas[i].length; y++) {

				if (pinArTag[i][y] == 1) {
					table.setValueAt("*" + pinakas[i][y] + "*", i, y);
				} else {
					table.setValueAt(pinakas[i][y], i, y);
				}

			}
		}

	}

	/********************************************************************************************/

	// Poses grames tha exei o pinakas
	public static int getMuchTr(String tag) {
		int index = tag.indexOf("<tr>");
		int count = 0;
		while (index != -1) {
			count++;
			tag = tag.substring(index + 1);
			index = tag.indexOf("<tr>");
		}
		return count;
	}

	public static int getTrTag(String tag) {

		String td = "<td>";
		String th = "<th>";
		int indexTh = tag.indexOf(th);
		int indexTd = tag.indexOf(td);
		int count = 0;

		while (indexTh != -1 || indexTd != -1) {

			if (indexTh == -1) {
				indexTh = tag.length() + 1;
			} else if (indexTd == -1) {
				indexTd = tag.length() + 1;
			}

			if (indexTh < indexTd) {

				count++;
				tag = tag.substring(indexTh + th.length());
			} else {

				count++;
				tag = tag.substring(indexTd + td.length());
			}
			indexTh = tag.indexOf(th);
			indexTd = tag.indexOf(td);

		}

		return count;
	}
}
