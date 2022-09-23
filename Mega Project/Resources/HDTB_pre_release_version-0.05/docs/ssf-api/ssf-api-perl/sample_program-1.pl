#!/usr/bin/perl

#$SSF_API = $ENV{'SSF_API'};
#require "$SSF_API/feature_filter.pl";
#require "$SSF_API/shakti_tree_api.pl";

use File::Basename;
$path = dirname($0);
#print "$path\n";

require "$path/lib/feature_filter.pl";
require "$path/lib/shakti_tree_api.pl";

# Read the Story (xml Document)
&read_story("$ARGV[0]");

# print the Story (xml Document)
&printstory();
