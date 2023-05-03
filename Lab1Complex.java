package lab1;

public class Complex {
    private int re;
    private int im;

    Complex(){}
    Complex(int re, int im) {
        this.re = re;
        this.im = im;
    }

    public int getRe() {
        return re;
    }

    public void setRe(int re) {
        this.re = re;
    }

    public int getIm() {
        return im;
    }

    public void setIm(int im) {
        this.im = im;
    }

    public static Complex sum(Complex a, Complex b){
        Complex s = new Complex();
        s.setRe(a.re + b.re);
        s.setIm(a.im + b.im);
        return s;
    }

    public static Complex product(Complex a, Complex b){
        int real = a.re * b.re - a.im * b.im;
        int im = a.re * b.im + a.im * b.re;

        return new Complex(real, im);
    }

    @Override
    public String toString(){
        if (im >= 0) {
            return re + "+" + im + "i";
        } else {
            return re + "" + im + "i";
        }
    }

}
