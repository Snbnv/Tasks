package ru.academits.bakanov.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public Range() {
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double x) {
        return (x >= from && x <= to);
    }

    public Range getIntersection(Range r1, Range r2) {
        if (r1.to < r2.from || r2.to < r1.from) {
            return null;
        } else {
            Range rangeIntersection = new Range();
            rangeIntersection.from = r1.from <= r2.from ? r2.from : r1.from;
            rangeIntersection.to = r1.to <= r2.to ? r1.to : r2.to;
            return rangeIntersection;
        }
    }

    public Range[] getUnion(Range r1, Range r2) {
        if (r1.to < r2.from || r2.to < r1.from) {
            return new Range[]{r1, r2};
            //System.out.printf("интервал объединения - (%.2f - %.2f,  %.2f - %.2f)", r1.from, r1.to, r2.from, r2.to);
            //System.out.println();
        } else {
            Range rangeNew = new Range();
            rangeNew.from = r1.from <= r2.from ? r1.from : r2.from;
            rangeNew.to = r1.to <= r2.to ? r2.to : r1.to;
            return new Range[]{rangeNew};
            //System.out.printf("интервал объединения (%.2f-%.2f)", this.from, this.to);
            //System.out.println();
        }
    }

    public void getDifference(Range r1, Range r2) {
        if (r1.to < r2.from || r2.to < r1.from) {
            this.from = r1.from;
            this.to = r1.to;
            System.out.printf("интервал разности (%.2f-%.2f)", this.from, this.to);
        } else if (r1.from < r2.from && r1.to > r2.to) {
            r1.to = r2.from;
            r2.from = r2.to;
            r2.to = r1.to;
            Range[] rangeNew = {r1, r2};
            System.out.printf("интервал разности - (%.2f - %.2f, %.2f - %.2f)", r1.from, r1.to, r2.from, r2.to);
            System.out.println();
        } else {
            System.out.printf("интервал разности (%.2f-%.2f)", r1.from, r2.from);
        }
    }
}



