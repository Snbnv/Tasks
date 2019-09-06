package ru.academits.bakanov.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
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

    public Range getIntersection(Range range) {
        if (range.to <= from || to <= range.from) {
            return null;
        } else {
            return new Range(Math.max(range.from, from), Math.min(range.to, to));
        }
    }

    public Range[] getUnion(Range range) {
        if (range.to < from || to < range.from) {
            return new Range[]{range, this};
        } else {
            return new Range[]{new Range(Math.min(range.from, from), Math.max(range.to, to))};
        }
    }

    public Range[] getDifference(Range range) {
        if (to <= range.from) {
            return new Range[]{this};
        } else if (from < range.from && to > range.to) {
            return new Range[]{new Range(from, range.from), new Range(range.to, to)};
        } else {
            return new Range[]{new Range(from, range.from)};
        }
    }
}

