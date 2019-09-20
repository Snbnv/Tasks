public class Converter {
    private double celsius;
    private double kelvin;
    private double fahrenheit;

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public double getKelvin() {
        return kelvin;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public void setFahrenheit(double fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }

    public void Converter() {
        if (getCelsius() != 0) {
            fahrenheit = getCelsius() * 9 / 5 + 32;
            kelvin = getCelsius() + 273.15;
        }
        if (getFahrenheit() != 0) {
            celsius = (getFahrenheit() - 32) * 5 / 9;
            kelvin = (getFahrenheit() - 32) * 5 / 9 + 273.15;
        }
        if (getKelvin() != 0) {
            celsius = getKelvin() - 273.15;
            fahrenheit = (getKelvin() - 273.15) * 9 / 5 + 32;
        }
    }
}
