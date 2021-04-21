# Name: Minh Nguyen
# Panther Id: 002-46-4288

my %hash;
my $ITERATION = 1500000;

sub generateName {
    my $str = "";
    for (my $i = 0; $i < 3; $i = $i + 1) {
        my $x = ord('A') + (int rand(25));
        my $c = chr($x);
        $str = "$str$c";
    }
    return $str;
}

sub generateAge() {
    return (1 + int rand(99));
}

sub usingHash() {
    for (my $i = 0; $i < $ITERATION; $i = $i + 1) {
        my $name = generateName();
        my $age = generateAge();
        $hash{$name} = $age;
    }
}

sub notUsingHash () {
    for (my $i = 0; $i < $ITERATION; $i = $i + 1) {
        my $name = generateName();
        my $age = generateAge();
    }
}

# Using hash
my $start = time;
usingHash();
my $duration = time - $start;
print "Using hash: $duration seconds\n";

# Not using hash
$start = time;
notUsingHash();
$duration = time - $start;
print "Not using hash: $duration seconds\n";

