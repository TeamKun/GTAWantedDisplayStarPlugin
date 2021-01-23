package net.kunmc.lab.gtawanteddisplaystarplugin.api;

/**
 * 追加オプションです。
 */
public enum Flag
{
    /**
     * 何もしないオプションです。
     */
    NONE(0x00),
    /**
     * 星が光るようになります。
     */
    BLINK(0x01);

    private final int value;
    private Number publicValue = 0;

    Flag(int value) {
        this.value = value;
    }

    /**
     * フラグが建っているか調査します。
     * @param value 調査するフラグ。
     * @return 建っているかどうか。
     */
    public boolean check(int value) {
        return (this.value & value) == this.value;
    }

    /**
     * フラグ配列を、ビットフラグにエンコードします。
     * @param flags フラグ配列。
     * @return エンコードされたビットフラグ。
     */
    public static int encode(Flag... flags)
    {
        int flag = 0;
        for(Flag f: flags)
            flag |= f.value;
        return flag;
    }

    /**
     * 値をセットします。
     * @param publicValue 値です。
     */
    public Flag setValue(Number publicValue)
    {
        this.publicValue = publicValue;
        return this;
    }

    /**
     * 値を取得します。
     * @return 値です。
     */
    public Number getValue()
    {
        return publicValue;
    }
}
