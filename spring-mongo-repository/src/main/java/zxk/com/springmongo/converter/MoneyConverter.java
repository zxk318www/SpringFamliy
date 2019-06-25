package zxk.com.springmongo.converter;

import org.bson.Document;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;

/**
 * @program: spring-mongo
 * @description:
 * @author: Zhangxike
 * @create: 2019-06-25 10:13
 **/
public class MoneyConverter implements Converter<Document, Money> {
    @Override
    public Money convert(Document document) {
        Document money = (Document) document.get("money");
        double amount = Double.parseDouble(money.getString("amount"));
        String currency = ((Document)money.get("currency")).getString("code");
        return Money.of(CurrencyUnit.of(currency),amount);
    }
}
