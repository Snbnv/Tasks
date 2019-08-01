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
        } else {
            Range rangeUnion = new Range();
            rangeUnion.from = r1.from <= r2.from ? r1.from : r2.from;
            rangeUnion.to = r1.to <= r2.to ? r2.to : r1.to;
            return new Range[]{rangeUnion};
        }
    }

    public Range[] getDifference(Range r1, Range r2) {
        if (r1.to < r2.from || r2.to < r1.from) {
            return new Range[]{r1};
        } else if (r1.isInside(r2.from) && r1.isInside(r2.to)) {
            Range part1 = new Range();
            Range part2 = new Range();
            part1.from = r1.from;
            part1.to = r2.from;
            part2.from = r2.to;
            part2.to = r1.to;
            return new Range[]{part1, part2};
        } else {
            Range rangeDifference = new Range(r1.from, r2.from);
            return new Range[]{rangeDifference};
        }
    }
}

