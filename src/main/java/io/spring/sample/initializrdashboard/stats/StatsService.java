package io.spring.sample.initializrdashboard.stats;

import java.util.List;
import java.util.stream.Collectors;

import io.spring.sample.initializrdashboard.stats.support.Event;
import io.spring.sample.initializrdashboard.stats.support.GenerationStatistics;
import io.spring.sample.initializrdashboard.stats.support.ReverseLookupDescriptor;
import io.spring.sample.initializrdashboard.stats.support.TopIpsDescriptor;

import org.springframework.stereotype.Service;

@Service
public class StatsService {

	private final StatsClient statsClient;

	private final ReverseLookupClient lookupClient;

	public StatsService(StatsClient statsClient, ReverseLookupClient lookupClient) {
		this.statsClient = statsClient;
		this.lookupClient = lookupClient;
	}

	public StatsContainer fetchStats(String fromDate, String toDate) {

		StatsContainer.Builder builder = StatsContainer.range(fromDate, toDate);

		GenerationStatistics generationStats = statsClient.fetchGenerationStats(fromDate, toDate);
		builder.addSeries(generationStats.getRecords());

		List<Event> events = statsClient.fetchEvents(fromDate, toDate);
		builder.addAnnotations(events);

		TopIpsDescriptor topIps = statsClient.fetchIps(fromDate, toDate);
		List<ReverseLookupDescriptor> resolvedIps = topIps.getIps()
				.parallelStream()
				.map(ip -> lookupClient.freeReverseLookup(ip))
				.collect(Collectors.toList());
		builder.addTopClients(resolvedIps);

		return builder.build();
	}

}
