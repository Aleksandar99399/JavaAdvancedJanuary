package MultidimensionalArraysExercises;

import java.util.*;

public class HeiganDance08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int playerHelth = 18500;
        double bossHealth = 3000000;

        double demage = Double.parseDouble (scanner.nextLine ( ));

        String lastSpell = "";

        int[] playrPosition = new int[2];
        playrPosition[0] = 7;
        playrPosition[1] = 7;

        boolean isInCloud = false;


        while (playerHelth > 0) {
            bossHealth -= demage;


            if (isInCloud) {
                playerHelth -= 3500;
                isInCloud = false;
            }

            if (playerHelth <= 0) {
                lastSpell = "Cloud";
                break;
            }

            if (bossHealth <= 0) {
                break;
            }

            String[] token = scanner.nextLine ( ).split ("\\s+");
            String spell = token[0];
            int targetRow = Integer.parseInt (token[1]);
            int targetCol = Integer.parseInt (token[2]);

            lastSpell = spell;

            boolean isPlayerDameged = chekPlayerIsMit (playrPosition[0], playrPosition[1], targetRow, targetCol);

            int damageDone = 0;
            if (isPlayerDameged) {
                if (spell.equals ("Cloud")) {
                    damageDone = 3500;
                } else {
                    damageDone = 6000;
                }
                boolean canMove = playrCanMoveAndMovePlayer (playrPosition, targetRow, targetCol);

                if (!canMove) {
                    playerHelth -= damageDone;
                    if (spell.equals ("Cloud")) {
                        isInCloud = true;
                    }
                }
            }
        }
        if (bossHealth > 0) {
            System.out.printf ("Heigan: %.2f%n", bossHealth);
        } else {
            System.out.println ("Heigan: Defeated!");
        }
        if (playerHelth <= 0) {
            lastSpell = lastSpell.equals ("Cloud") ? "Plague Cloud" : lastSpell;
            System.out.printf ("Player: Killed by %s%n", lastSpell);
        } else {
            System.out.println (String.format ("Player: %d", playerHelth));
        }
        System.out.println (String.format ("Final position: %d, %d", playrPosition[0], playrPosition[1]));
    }

    private static boolean playrCanMoveAndMovePlayer(int[] position, int row, int col) {
        boolean canMove = false;
        int r = position[0];
        int c = position[1];

        if (isInBounds (r - 1, c) && !chekPlayerIsMit (r - 1, c, row, col)) {
            r--;
            canMove = true;
        } else if (isInBounds (r, c + 1) && !chekPlayerIsMit (r, c + 1, row, col)) {
            c++;
            canMove = true;
        } else if (isInBounds (r + 1, c) && !chekPlayerIsMit (r + 1, c, row, col)) {
            r++;
            canMove = true;
        } else if (isInBounds (r, c - 1) && !chekPlayerIsMit (r, c - 1, row, col)) {
            c--;
            canMove = true;
        }

        position[0] = r;
        position[1] = c;

        return canMove;
    }

    private static boolean isInBounds(int r, int c) {
        return r >= 0 && r < 15
                && c >= 0 && c < 15;
    }

    private static boolean chekPlayerIsMit(int r, int c, int targetRow, int targetCol) {
        return r >= targetRow - 1 && r <= targetRow + 1
                && c >= targetCol - 1 && c <= targetCol + 1;
    }
}