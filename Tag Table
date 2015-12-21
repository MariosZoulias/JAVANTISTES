/*
*o kodikas douleuei alla tha ton ksananebaso molis ton simazepso ligo kai prostheso kapia pragmata
*
*ti thelo na prostheso:
* + to tag caption (o titlos tou table)
* --(exo ftiaksei to programma pou to bgazei ton titlo alla den to emfanizei akoma)
* + opou briskei to tag <th> na emfaniezei me kefalea to periexomeno tou tag
*
*Eos tis 23/12/2015 tha einai etimo
*
*/

import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Vector;

public class TagTable {

	public static void main(String[] argv) throws Exception {

		// Diabazei to tag*******

		String tag = "<table style=width:100%> " + "<tr> " + "<th>Firstname</th>" + "<th>Lastname</th> "
				+ "<th>Points</th>" + "</tr>" + "<tr>" + "<td>Eve</td>" + "<td>Jackson</td> " + "<td>94</td>" + "</tr>"
				+ "</table>";

		// to mikos tou tag pou isix8ei

		String caption = "<caption>";
		int thesiNow = 0;
		String tr = "<tr>";
		String trEnd = "</tr>";
		String tagNow;
		int thesiTelous;
		String trTag;
		int muchTr;
		int muchRow;

		// An to caption iparxei sto tag ftiaxnei ena String me to periexomeno
		// tis etiketas
		if (tag.contains(caption)) {
			// i arxiki 8esi tou Caption mesa sto String
			int capBegin = tag.indexOf(caption) + caption.length();
			String endCaption = "</caption>";
			// i teliki 8esi tou Caption
			int capend = tag.indexOf(endCaption);

			String epikefalida = tag.substring(capBegin, capend);

			thesiNow = capend + endCaption.length();
			tagNow = getTagNow(thesiNow, tag.length(), tag);
			// System.out.println(tagNow);
		} else {
			thesiNow = tag.indexOf(tr);
			tagNow = getTagNow(thesiNow, tag.length(), tag);
			// System.out.println(tagNow);
		}

		// Poses grammes exei to
		// tag*******************************************************
		// Ftiaxnei tis stiles tou pinaka
		muchTr = getMuchTr(tagNow);
		String[][] pinakas = new String[muchTr][];
		int howRow = 0;

		int indexTh;
		int indexTd;

		int indexEndTh;
		int indexEndTd;

		String rowString;

		thesiTelous = tagNow.indexOf(trEnd);
		trTag = getTagNow(0, thesiTelous, tagNow);

		tagNow = tagNow.substring(thesiTelous + 5);
		try {

			while (trTag.contains(tr)) {

				int countRow = 0;
				String st = null;
				indexTh = 0;
				indexTd = 0;
				muchRow = getTrTag(trTag);
				int countTr = 0;

				pinakas[howRow] = new String[muchRow];

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

					} else if (indexTd < indexTh && indexTd != -1) {
						// I thesi pou telionei to tag
						indexEndTd = trTag.indexOf("</td>");
						// ftiaxnei to onoma pou iparxei mesa sto tag

						st = trTag.substring(indexTd + 4, indexEndTd);
						trTag = trTag.substring(indexEndTd + 1);

					}
					pinakas[howRow][countRow] = st;

					indexTh = trTag.indexOf("<th>");
					indexTd = trTag.indexOf("<td>");
					countRow++;
				}
				howRow++;

				thesiTelous = tagNow.indexOf(trEnd);
				trTag = getTagNow(0, thesiTelous, tagNow);

				indexTh = tagNow.indexOf("<th>");
				indexTd = tagNow.indexOf("<td>");

				tagNow = tagNow.substring(thesiTelous);

			}

			/*******************************************************************************/

			int column = 0;

			for (int i = 0; i < pinakas.length; i++) {
				if (pinakas[i].length > column) {
					column = pinakas[i].length;
				}
			}
		

			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JTable table = new JTable(howRow, column);
			table.setTableHeader(null);
			JScrollPane scrollPane = new JScrollPane(table);
			frame.add(scrollPane, BorderLayout.CENTER);
			frame.setSize(300, 150);
			frame.setVisible(true);

			for (int i = 0; i < howRow; i++) {
				for (int y = 0; y < pinakas[i].length; y++) {
					table.setValueAt(pinakas[i][y], i, y);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	/********************************************************************************************/

	public static String getTagNow(int thesi1, int thesi2, String tag) {
		return tag.substring(thesi1, thesi2);
	}

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
				tag = tag.substring(indexTh + 5);
			} else {

				count++;
				tag = tag.substring(indexTd + 1);
			}
			indexTh = tag.indexOf(th);
			indexTd = tag.indexOf(td);

		}
		/*
		 * for(int i = 0 ;i <=intList.size(); i++){
		 * System.out.println(intList.get(i)); }
		 */

		return count;
	}
}
