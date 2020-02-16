//package org.helllynx.marketstat.repository.network.finnhub.api.model
//
//import kotlinx.serialization.Decoder
//import kotlinx.serialization.Encoder
//import kotlinx.serialization.KSerializer
//import kotlinx.serialization.Serializer
//import kotlinx.serialization.internal.StringDescriptor
//import kotlinx.serialization.withName
//import org.joda.time.DateTime
//import org.joda.time.format.ISODateTimeFormat
//import java.util.Base64
//
//@Serializer(forClass = DateTime::class)
//object DateTimeSerializer : KSerializer<DateTime> {
//
//    private val formatter = ISODateTimeFormat.dateTime()
//    private val parser = ISODateTimeFormat.dateTimeParser().withOffsetParsed()
//
//    override val descriptor = StringDescriptor.withName("DateTime")
//
//    override fun serialize(encoder: Base64.Encoder, obj: DateTime) =
//        encoder.encodeString(formatter.print(obj))
//
//    override fun deserialize(decoder: Decoder) =
//        parser.parseDateTime(decoder.decodeString())
//}
