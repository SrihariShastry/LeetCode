package com.leetcode.Companies.GoldmanSachs;

public class ReachingPoints {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            // Gotta reduce target points to reach source.
            // Since we have the equation in the form (x+y,y) || (x,x+y) ==> (tx,ty)
            // we convert it to the form (x+ky,y) (x,x+ky)
            // to reduce tx and ty to sx and sy,

            if (tx < ty)
                ty %= tx;
            else
                tx %= ty;
        }

        /*
         * if tx reached sx and ty >=sy, then ty will be of the form ty = sx + k*sy
         * (i.e., ty will be some multiple of sy) so we remove the sx part from our ty.
         * Now ty will be some multiple of sy
         * so if ty % sy == 0, then we can safely say that it can be reduced to sy.
         *
         * else if ty reaches sy and tx>=sx, then tx will be of the form tx = k*sx + sy
         * (i.e., tx will be some multiple of sx) so we remove the sy part from our tx.
         * Now tx will be some multiple of sx.
         * So if tx % sx == 0, then we can safely say that it can be reduced to sx.
         */

        return sx == tx && sy <= ty && ((ty - sy) % sx == 0) ||
                sy == ty && sx <= tx && ((tx - sx) % sy == 0);
    }
}
