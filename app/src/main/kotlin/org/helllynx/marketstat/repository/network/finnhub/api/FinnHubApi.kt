//package org.helllynx.marketstat.repository.network.finnhub.api
//
//import retrofit2.http.Body
//import retrofit2.http.GET
//import retrofit2.http.PUT
//import retrofit2.http.Path
//import retrofit2.http.Query
//
//@Suppress("ComplexInterface")
//internal interface FinnHubApi {
//
//    @GET("{address}/transactions/hashes")
//    suspend fun getTransactionsHashes(
//        @Path("address") address: String,
//        @Query("from_tx_hash") fromHash: String? = null
//    ): List<TransactionHash>
//
//    @GET("{address}/transactions/hashes")
//    suspend fun getTransactionsHashes(
//        @Path("address") address: String,
//        @Query("from_block") fromBlock: Long? = null
//    ): List<TransactionHash>
//
//    @GET("{address}/transactions")
//    suspend fun getTransactions(
//        @Path("address") address: String,
//        @Query("from_block") fromBlock: Long? = null,
//        @Query("to_block") toBlock: Long? = null
//    ): List<Transaction>
//
//    @GET("{address}/transactions")
//    suspend fun getTransactions(
//        @Path("address") address: String,
//        @Query("from_hash") fromTransactionHash: String? = null,
//        @Query("to_hash") toTransactionHash: String? = null
//    ): List<Transaction>
//
//    @GET("transactions")
//    suspend fun getTransaction(@Query("hash") hash: String): Transaction?
//
//
//    @PUT("transactions")
//    suspend fun sendTransaction(@Body data: String): String
//}
